<template>
<div>
  <vue-snotify></vue-snotify>
<div>
<div class="columns section">
  <div class="column is-one-third is-offset-one-third">
    <router-view/>    
    </div>
</div>    
</div>    
</div>
</template>

<script>
  import Profile from './components/Profile.vue'
  import SingleImagePage from './components/SingleImagePage.vue'

  export default {
    name: 'App',
    components:{
      Profile,
      SingleImagePage
    }
  }
</script>
