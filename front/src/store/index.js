import { defineStore } from "pinia";

const URL_BASE = "http://localhost:8080/api/v1/todo-app";

export const useTasksStore = defineStore('tasks', {
    state: () => ({ tasks: [] }),
    getters: { gettAllTask: (state) => state.stateTasks },
    actions: {
        async getTask() {
            const resp = await fetch(URL_BASE);
            const data = await resp.json()
            data.forEach(t => {
                const ta = {
                    id_task: t.id_task,
                    description: t.description,
                    is_completed: t.is_completed
                }
                this.tasks.push(ta)
            });
        },
        async saveTask(t) {
            this.tasks = []
            const task = {
                description: t,
            }
            const resp = await fetch(URL_BASE, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(task)
            })
            const { msg, status_code } = await resp.json()
            if (status_code == 201) {
                this.getTask()
                alert(msg)
                return;
            }
            alert(msg)
        },
        async updateTask(task) {
            this.tasks = []
            const resp = await fetch(URL_BASE, {
                method: "PUT",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(task)
            })
            const { msg, status_code } = await resp.json()
            if (status_code == 200) {
                this.getTask()
                alert(msg)
                return;
            }
            alert(msg)
        }
    }
})