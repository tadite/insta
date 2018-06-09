import Vue from 'vue'
import Router from 'vue-router'
import Profile from '@/components/Profile'
import ImageUploadPanel from '@/components/ImageUploadPanel'
import ProfileEdit from '@/components/ProfileEdit'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path:'/',
      redirect:'/profile'
    },
    {
      path: '/profile/:profileId?/:imageId?',
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
    }
  ]
})
