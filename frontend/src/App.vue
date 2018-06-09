<template>
<div>
<div>
<div class="columns is-mobile section">
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
