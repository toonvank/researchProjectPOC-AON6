// import './assets/main.css'
import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'
import './index.css'
import Swal from 'sweetalert2';
import VueCameraLib from 'vue-camera-lib'



const Toast = Swal.mixin({
    toast: true,
    position: 'top',
    showConfirmButton: false,
    timer: 3000,
    timerProgressBar: true,
    didOpen: (toast) => {
        toast.addEventListener('mouseenter', Swal.stopTimer);
        toast.addEventListener('mouseleave', Swal.resumeTimer);
    }
});

const app = createApp(App)

app.config.globalProperties.$toast = Toast;


app.use(router)
app.use(createPinia())
app.use(VueCameraLib)

app.mount('#app')
