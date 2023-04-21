<template>
    <div class="relative overflow-y-auto mt-5 rounded-md flex justify-center">
        <table class="max-w-2xl  overflow-y-scroll  text-xl text-gray-500 dark:text-gray-400">
            <thead class="text-1xl bg-white text-black">
                <tr>
                    <th scope="col" class="px-6 py-3">Id</th>
                    <th scope="col" class="px-6 py-3">Task</th>
                    <th scope="col" class="px-6 py-3">¿Is Completed?</th>
                    <th scope="col" class="px-6 py-3">Actions</th>
                </tr>
            </thead>
            <tbody class="break-all">
                <tr v-if="thereData" class="bg-white border-b dark:bg-gray-800 dark:border-gray-700" v-for="task in  tasks "
                    :key="task.id_task">
                    <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                        {{ task.id_task }}
                    </th>
                    <td class="px-6 py-4 ">{{ task.description }}</td>
                    <td class="px-6 py-4 text-center">
                        <input type="checkbox" v-model="task.is_completed" :checked="task.is_completed"
                            class="w-8 h-4 rounded-md outline-none" />
                    </td>
                    <td class="px-6 py-4"><button @click.prevent="finish(task.id_task)"
                            class="p-3 bg-green-900 text-gray-500 rounded-lg text-sm font-bold hover:text-white  hover:bg-green-400">finish</button>
                    </td>
                </tr>
                <span v-else class="text-slate-300 text-3xl font-bold">No tasks</span>
            </tbody>

        </table>
    </div>
</template>

<script>
import { onMounted, computed, ref, reactive } from 'vue';
import { useTasksStore } from '../store/index.js'
import { storeToRefs } from 'pinia';
export default {
    setup() {
        const store = useTasksStore()

        const { tasks } = storeToRefs(store)

        onMounted(() => {
            store.getTask()
        })
        const finish = (id) => {
            const find = tasks.value.find(t => t.id_task == id)
            const objectTask = {
                id_task: id,
                description: find.description,
                is_completed: find.is_completed
            }
            store.updateTask(objectTask)
        }
        const thereData = computed(() => {
            return tasks.value.length > 0 ? true : false
        })

        return { tasks, finish, thereData };
    },
};
</script>

<style lang="scss" scoped></style>
