<template>
<nav class="level pb20">
<article class="media">
  <div class="media-content">
    
      
        
          <strong>{{profileData.fullname}}</strong><small>@{{profileData.username}}</small>
        
        <br>{{profileData.info}}
      
  </div>
  
</article>  
<div class="edit-btn">
  <router-link :to="{name: 'Profile', params: {edit: !editing}}" tag="a" class="fas fa-user-edit"/>
</div>

</nav>
</template>

<script>  
  
  export default {
    name: "ProfileDataPanel",
    props: ['profileData', 'editing']
  };

</script>
