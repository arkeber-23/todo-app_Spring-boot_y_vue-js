<template>
  <div class="container p-4 flex justify-center w-screen mt-12">
    <div class="flex-col justify-center items-center">
      <addTask></addTask>
      <listTask></listTask>
    </div>
  </div>
</template>

<script>
import listTask from "./components/listTask.vue";
import addTask from "./components/addTask.vue";
export default {
  components: {
    listTask,
    addTask,
  },
  setup() {
    return {};
  },
};
</script>

<style lang="scss" scoped></style>
