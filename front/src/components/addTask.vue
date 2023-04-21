<template>
  <div class="">
    <h1 class="text-center text-4xl text-red-400 m-4 font-bold">TODO-APP</h1>
    <form @submit.prevent="addTask">
      <div class="flex justify-center items-center gap-4">
        <input type="text" v-model="newTask"
          class="bg-white font-bold placeholder:text-red-300 placeholder:text-2xl placeholder:px-3 px-3 text-black text-2xl rounded-md h-10 outline-none"
          placeholder="Insert new task" />
        <input type="submit" class="cursor-pointer font-bold bg-yellow-300 p-2 rounded-md text-black" value="Add" />
      </div>
    </form>
  </div>
</template>
<script>
import { ref, watchEffect } from 'vue';
import { useTasksStore } from '../store/index.js'
import { storeToRefs } from 'pinia';
export default {
  setup() {
    const newTask = ref("")
    const store = useTasksStore()
    const { tasks } = storeToRefs(store)

    const addTask = () => {
      store.saveTask(newTask.value)
      newTask.value = ""
    }
    return { addTask, newTask };
  },
};
</script>

<style lang="scss" scoped></style>
