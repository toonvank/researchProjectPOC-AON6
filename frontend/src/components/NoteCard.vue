<template>
  <RouterLink :to="'add-note/'+note.id">
    <div class="rounded-lg border bg-gray-800 text-gray-300 shadow-sm relative group overflow-hidden" data-v0-t="card">
      <a class="absolute inset-0 z-10" href="#">
        <span class="sr-only">View note</span>
      </a>
      <div class="p-6 h-full">
        <div class="flex flex-col justify-between h-full">
          <div>
            <h3 class="text-lg font-semibold">{{ note.title }}</h3>
            <p class="line-clamp-3 text-sm text-gray-500 dark:text-gray-400">{{ note.content }}</p>
          </div>
          <div class="flex items-center justify-between mt-2">
            <div class="flex items-center gap-2 text-sm text-gray-500 dark:text-gray-400">
              <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="h-4 w-4">
                <rect width="18" height="18" x="3" y="4" rx="2" ry="2"></rect>
                <line x1="16" x2="16" y1="2" y2="6"></line>
                <line x1="8" x2="8" y1="2" y2="6"></line>
                <line x1="3" x2="21" y1="10" y2="10"></line>
              </svg>
              <span>{{ note.date }}</span>
            </div>
            <button class="inline-flex items-center justify-center whitespace-nowrap rounded-md text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 hover:bg-gray-700 hover:text-gray-200 h-10 w-10"></button>
          </div>
        </div>
      </div>
    </div>
  </RouterLink>
</template>

<script>
export default {
  props: {
    note: {
      type: Object,
      required: true,
    },
  },
};
</script>

<style>
/* Add any custom styles here */
</style>
