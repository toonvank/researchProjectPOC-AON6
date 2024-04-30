<template>

  <div class="grid grid-cols-1 min-h-screen w-full">
    <div class="flex flex-col">
      <header class="flex h-14 items-center gap-4 border-b bg-gray-100/40 px-4 dark:bg-gray-800/40 md:h-[60px] md:px-6">
        <a class="md:hidden" href="#">
          <svg
              xmlns="http://www.w3.org/2000/svg"
              width="24"
              height="24"
              viewBox="0 0 24 24"
              fill="none"
              stroke="currentColor"
              stroke-width="2"
              stroke-linecap="round"
              stroke-linejoin="round"
              class="h-6 w-6"
          >
            <path d="m3 21 1.9-5.7a8.5 8.5 0 1 1 3.8 3.8z"></path>
          </svg>
          <span class="sr-only">MemoSphere</span>
        </a>
        <div class="w-full flex-1">
          <form>
            <div class="relative">
              <svg
                  xmlns="http://www.w3.org/2000/svg"
                  width="24"
                  height="24"
                  viewBox="0 0 24 24"
                  fill="none"
                  stroke="currentColor"
                  stroke-width="2"
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  class="absolute left-2.5 top-2.5 h-4 w-4 text-gray-500 dark:text-gray-400"
              >
                <circle cx="11" cy="11" r="8"></circle>
                <path d="m21 21-4.3-4.3"></path>
              </svg>
              <input
                  type="text"
                  placeholder="Search notes"
                  class="bg-transparent pl-10 pr-3 py-2 w-full rounded-md border border-transparent focus:ring-2 focus:ring-primary focus:ring-offset-background focus:outline-none dark:text-gray-100">
            </div>
          </form>
        </div>
      </header>
      <main class="flex-1 flex flex-col gap-4 p-4 md:gap-8 md:p-6">
        <div class="flex items-center">
          <h1 class="font-semibold text-lg md:text-2xl">Notes</h1>
          <button class="inline-flex items-center justify-center whitespace-nowrap text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 bg-primary text-primary-foreground hover:bg-primary/90 h-9 rounded-md px-3 ml-auto">
            <svg
                xmlns="http://www.w3.org/2000/svg"
                width="24"
                height="24"
                viewBox="0 0 24 24"
                fill="none"
                stroke="currentColor"
                stroke-width="2"
                stroke-linecap="round"
                stroke-linejoin="round"
                class="h-4 w-4 mr-2"
            >
              <path d="M5 12h14"></path>
              <path d="M12 5v14"></path>
            </svg>
            New Note
          </button>
        </div>
        <div class="grid grid-cols-1 gap-4 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4">
          <div
              class="rounded-lg border bg-card text-card-foreground shadow-sm relative group overflow-hidden"
              data-v0-t="card"
          >
            <a class="absolute inset-0 z-10" href="#">
              <span class="sr-only">View note</span>
            </a>
            <div class="p-6 h-full">
              <div class="flex h-full flex-col justify-between">
                <div>
                  <h3 class="text-lg font-semibold">Meeting Notes</h3>
                  <p class="line-clamp-3 text-sm text-gray-500 dark:text-gray-400">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed euismod, nisl nec ultricies lacus,
                    nisl nec ultricies lacus.
                  </p>
                </div>
                <div class="flex items-center justify-between">
                  <div class="flex items-center gap-2 text-sm text-gray-500 dark:text-gray-400">
                    <svg
                        xmlns="http://www.w3.org/2000/svg"
                        width="24"
                        height="24"
                        viewBox="0 0 24 24"
                        fill="none"
                        stroke="currentColor"
                        stroke-width="2"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                        class="h-4 w-4"
                    >
                      <rect width="18" height="18" x="3" y="4" rx="2" ry="2"></rect>
                      <line x1="16" x2="16" y1="2" y2="6"></line>
                      <line x1="8" x2="8" y1="2" y2="6"></line>
                      <line x1="3" x2="21" y1="10" y2="10"></line>
                    </svg>
                    <span>April 30, 2024</span>
                  </div>
                  <button class="inline-flex items-center justify-center whitespace-nowrap rounded-md text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 hover:bg-accent hover:text-accent-foreground h-10 w-10">
                    <svg
                        xmlns="http://www.w3.org/2000/svg"
                        width="24"
                        height="24"
                        viewBox="0 0 24 24"
                        fill="none"
                        stroke="currentColor"
                        stroke-width="2"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                        class="h-4 w-4"
                    >
                      <circle cx="12" cy="12" r="1"></circle>
                      <circle cx="12" cy="5" r="1"></circle>
                      <circle cx="12" cy="19" r="1"></circle>
                    </svg>
                    <span class="sr-only">More options</span>
                  </button>
                </div>
              </div>
            </div>
          </div>
          <div
              class="rounded-lg border bg-card text-card-foreground shadow-sm relative group overflow-hidden"
              data-v0-t="card"
          >
            <a class="absolute inset-0 z-10" href="#">
              <span class="sr-only">View note</span>
            </a>
            <div class="p-6 h-full">
              <div class="flex h-full flex-col justify-between">
                <div>
                  <h3 class="text-lg font-semibold">Project Roadmap</h3>
                  <p class="line-clamp-3 text-sm text-gray-500 dark:text-gray-400">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed euismod, nisl nec ultricies lacus,
                    nisl nec ultricies lacus.
                  </p>
                </div>
                <div class="flex items-center justify-between">
                  <div class="flex items-center gap-2 text-sm text-gray-500 dark:text-gray-400">
                    <svg
                        xmlns="http://www.w3.org/2000/svg"
                        width="24"
                        height="24"
                        viewBox="0 0 24 24"
                        fill="none"
                        stroke="currentColor"
                        stroke-width="2"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                        class="h-4 w-4"
                    >
                      <rect width="18" height="18" x="3" y="4" rx="2" ry="2"></rect>
                      <line x1="16" x2="16" y1="2" y2="6"></line>
                      <line x1="8" x2="8" y1="2" y2="6"></line>
                      <line x1="3" x2="21" y1="10" y2="10"></line>
                    </svg>
                    <span>April 28, 2024</span>
                  </div>
                  <button class="inline-flex items-center justify-center whitespace-nowrap rounded-md text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 hover:bg-accent hover:text-accent-foreground h-10 w-10">
                    <svg
                        xmlns="http://www.w3.org/2000/svg"
                        width="24"
                        height="24"
                        viewBox="0 0 24 24"
                        fill="none"
                        stroke="currentColor"
                        stroke-width="2"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                        class="h-4 w-4"
                    >
                      <circle cx="12" cy="12" r="1"></circle>
                      <circle cx="12" cy="5" r="1"></circle>
                      <circle cx="12" cy="19" r="1"></circle>
                    </svg>
                    <span class="sr-only">More options</span>
                  </button>
                </div>
              </div>
            </div>
          </div>
          <div
              class="rounded-lg border bg-card text-card-foreground shadow-sm relative group overflow-hidden"
              data-v0-t="card"
          >
            <a class="absolute inset-0 z-10" href="#">
              <span class="sr-only">View note</span>
            </a>
            <div class="p-6 h-full">
              <div class="flex h-full flex-col justify-between">
                <div>
                  <h3 class="text-lg font-semibold">Brainstorming Ideas</h3>
                  <p class="line-clamp-3 text-sm text-gray-500 dark:text-gray-400">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed euismod, nisl nec ultricies lacus,
                    nisl nec ultricies lacus.
                  </p>
                </div>
                <div class="flex items-center justify-between">
                  <div class="flex items-center gap-2 text-sm text-gray-500 dark:text-gray-400">
                    <svg
                        xmlns="http://www.w3.org/2000/svg"
                        width="24"
                        height="24"
                        viewBox="0 0 24 24"
                        fill="none"
                        stroke="currentColor"
                        stroke-width="2"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                        class="h-4 w-4"
                    >
                      <rect width="18" height="18" x="3" y="4" rx="2" ry="2"></rect>
                      <line x1="16" x2="16" y1="2" y2="6"></line>
                      <line x1="8" x2="8" y1="2" y2="6"></line>
                      <line x1="3" x2="21" y1="10" y2="10"></line>
                    </svg>
                    <span>April 25, 2024</span>
                  </div>
                  <button class="inline-flex items-center justify-center whitespace-nowrap rounded-md text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 hover:bg-accent hover:text-accent-foreground h-10 w-10">
                    <svg
                        xmlns="http://www.w3.org/2000/svg"
                        width="24"
                        height="24"
                        viewBox="0 0 24 24"
                        fill="none"
                        stroke="currentColor"
                        stroke-width="2"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                        class="h-4 w-4"
                    >
                      <circle cx="12" cy="12" r="1"></circle>
                      <circle cx="12" cy="5" r="1"></circle>
                      <circle cx="12" cy="19" r="1"></circle>
                    </svg>
                    <span class="sr-only">More options</span>
                  </button>
                </div>
              </div>
            </div>
          </div>
          <div
              class="rounded-lg border bg-card text-card-foreground shadow-sm relative group overflow-hidden"
              data-v0-t="card"
          >
            <a class="absolute inset-0 z-10" href="#">
              <span class="sr-only">View note</span>
            </a>
            <div class="p-6 h-full">
              <div class="flex h-full flex-col justify-between">
                <div>
                  <h3 class="text-lg font-semibold">Design Inspiration</h3>
                  <p class="line-clamp-3 text-sm text-gray-500 dark:text-gray-400">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed euismod, nisl nec ultricies lacus,
                    nisl nec ultricies lacus.
                  </p>
                </div>
                <div class="flex items-center justify-between">
                  <div class="flex items-center gap-2 text-sm text-gray-500 dark:text-gray-400">
                    <svg
                        xmlns="http://www.w3.org/2000/svg"
                        width="24"
                        height="24"
                        viewBox="0 0 24 24"
                        fill="none"
                        stroke="currentColor"
                        stroke-width="2"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                        class="h-4 w-4"
                    >
                      <rect width="18" height="18" x="3" y="4" rx="2" ry="2"></rect>
                      <line x1="16" x2="16" y1="2" y2="6"></line>
                      <line x1="8" x2="8" y1="2" y2="6"></line>
                      <line x1="3" x2="21" y1="10" y2="10"></line>
                    </svg>
                    <span>April 22, 2024</span>
                  </div>
                  <button class="inline-flex items-center justify-center whitespace-nowrap rounded-md text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 hover:bg-accent hover:text-accent-foreground h-10 w-10">
                    <svg
                        xmlns="http://www.w3.org/2000/svg"
                        width="24"
                        height="24"
                        viewBox="0 0 24 24"
                        fill="none"
                        stroke="currentColor"
                        stroke-width="2"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                        class="h-4 w-4"
                    >
                      <circle cx="12" cy="12" r="1"></circle>
                      <circle cx="12" cy="5" r="1"></circle>
                      <circle cx="12" cy="19" r="1"></circle>
                    </svg>
                    <span class="sr-only">More options</span>
                  </button>
                </div>
              </div>
            </div>
          </div>
          <div
              class="rounded-lg border bg-card text-card-foreground shadow-sm relative group overflow-hidden"
              data-v0-t="card"
          >
            <a class="absolute inset-0 z-10" href="#">
              <span class="sr-only">View note</span>
            </a>
            <div class="p-6 h-full">
              <div class="flex h-full flex-col justify-between">
                <div>
                  <h3 class="text-lg font-semibold">Travel Itinerary</h3>
                  <p class="line-clamp-3 text-sm text-gray-500 dark:text-gray-400">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed euismod, nisl nec ultricies lacus,
                    nisl nec ultricies lacus.
                  </p>
                </div>
                <div class="flex items-center justify-between">
                  <div class="flex items-center gap-2 text-sm text-gray-500 dark:text-gray-400">
                    <svg
                        xmlns="http://www.w3.org/2000/svg"
                        width="24"
                        height="24"
                        viewBox="0 0 24 24"
                        fill="none"
                        stroke="currentColor"
                        stroke-width="2"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                        class="h-4 w-4"
                    >
                      <rect width="18" height="18" x="3" y="4" rx="2" ry="2"></rect>
                      <line x1="16" x2="16" y1="2" y2="6"></line>
                      <line x1="8" x2="8" y1="2" y2="6"></line>
                      <line x1="3" x2="21" y1="10" y2="10"></line>
                    </svg>
                    <span>April 18, 2024</span>
                  </div>
                  <button class="inline-flex items-center justify-center whitespace-nowrap rounded-md text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 hover:bg-accent hover:text-accent-foreground h-10 w-10">
                    <svg
                        xmlns="http://www.w3.org/2000/svg"
                        width="24"
                        height="24"
                        viewBox="0 0 24 24"
                        fill="none"
                        stroke="currentColor"
                        stroke-width="2"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                        class="h-4 w-4"
                    >
                      <circle cx="12" cy="12" r="1"></circle>
                      <circle cx="12" cy="5" r="1"></circle>
                      <circle cx="12" cy="19" r="1"></circle>
                    </svg>
                    <span class="sr-only">More options</span>
                  </button>
                </div>
              </div>
            </div>
          </div>
          <div
              class="rounded-lg border bg-card text-card-foreground shadow-sm relative group overflow-hidden"
              data-v0-t="card"
          >
            <a class="absolute inset-0 z-10" href="#">
              <span class="sr-only">View note</span>
            </a>
            <div class="p-6 h-full">
              <div class="flex h-full flex-col justify-between">
                <div>
                  <h3 class="text-lg font-semibold">Recipe Ideas</h3>
                  <p class="line-clamp-3 text-sm text-gray-500 dark:text-gray-400">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed euismod, nisl nec ultricies lacus,
                    nisl nec ultricies lacus.
                  </p>
                </div>
                <div class="flex items-center justify-between">
                  <div class="flex items-center gap-2 text-sm text-gray-500 dark:text-gray-400">
                    <svg
                        xmlns="http://www.w3.org/2000/svg"
                        width="24"
                        height="24"
                        viewBox="0 0 24 24"
                        fill="none"
                        stroke="currentColor"
                        stroke-width="2"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                        class="h-4 w-4"
                    >
                      <rect width="18" height="18" x="3" y="4" rx="2" ry="2"></rect>
                      <line x1="16" x2="16" y1="2" y2="6"></line>
                      <line x1="8" x2="8" y1="2" y2="6"></line>
                      <line x1="3" x2="21" y1="10" y2="10"></line>
                    </svg>
                    <span>April 15, 2024</span>
                  </div>
                  <button class="inline-flex items-center justify-center whitespace-nowrap rounded-md text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 hover:bg-accent hover:text-accent-foreground h-10 w-10">
                    <svg
                        xmlns="http://www.w3.org/2000/svg"
                        width="24"
                        height="24"
                        viewBox="0 0 24 24"
                        fill="none"
                        stroke="currentColor"
                        stroke-width="2"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                        class="h-4 w-4"
                    >
                      <circle cx="12" cy="12" r="1"></circle>
                      <circle cx="12" cy="5" r="1"></circle>
                      <circle cx="12" cy="19" r="1"></circle>
                    </svg>
                    <span class="sr-only">More options</span>
                  </button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </main>
    </div>
  </div>
</template>

<script>
export default {

}
</script>

<style>
/* Add any custom styles here */
</style>
