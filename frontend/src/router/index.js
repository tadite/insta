import Vue from 'vue'
import Router from 'vue-router'
import Profile from '@/components/Profile'
import ImageUploadPanel from '@/components/ImageUploadPanel'
import ProfileEdit from '@/components/ProfileEdit'
import LoginPage from '@/components/LoginPage'
import RegistrationPage from '@/components/RegistrationPage'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path:'/',
      redirect:'/signin'
    },
    {
      path: '/profile/:profileId/:imageId?',
      name: 'Profile',
      component: Profile,
    },
    {
      path: '/imageUpload',
      name: 'ImageUploadPanel',
      component: ImageUploadPanel,
      props: true
    },
    {
      path: '/profileEdit',
      name: 'ProfileEdit',
      component: ProfileEdit,
      props: true
    },
    {
      path: '/signin',
      name: 'LoginPage',
      component: LoginPage,
      props: true
    },
    {
      path: '/signup',
      name: 'RegistrationPage',
      component: RegistrationPage,
      props: true
    }
  ]
})
