<template>
  <nav class="level pb20">
    <article class="media">
      <div class="media-content">

        <strong>{{profileData.fullname}}</strong>
        <small>@{{profileData.username}}</small>

        <br>{{profileData.info}}

      </div>

    </article>
    <div class="edit-container">
      <router-link tag="i" class="fas fa-plus-square edit-btn" to="/imageUpload"></router-link>
      <router-link tag="i" class="fas fa-pen-square edit-btn" to="/profileEdit"></router-link>
    </div>

  </nav>
</template>


<script>  
  
  export default {
    name: "ProfileDataPanel",
    props: ['profileData']
  };

</script>
