<template>
<div>
<ProfileDataPanel :profileData="profileData"/>
<ProfileImageTile :imageIds="imageIds"/>
<SingleImageModal :imageId="this.$route.params.imageId"/>
</div>
</template>

<script>  
  import ProfileImageTile from "./ProfileImageTile.vue"
  import ProfileDataPanel from "./ProfileDataPanel.vue"
  import SingleImageModal from "./SingleImageModal.vue"

  export default {
    name: "Profile",
    data: function () {
      return {
        profileData:{
          fullname: 'Andrey Nazarov',
          info: 'My super profile'
        }
      }
    },
    watch: {
      '$route' (to, from) {
        console.log(this.$route.params.profileId)
        console.log(this.$route.params.imageId)
        this.fetchProfileData(this.$route.params.profileId);
      }
    },
    methods: {
      fetchProfileData: function(profileId){
        
        console.log('fetch profile '+profileId);
        //this.$http.get('/post/' + postId).then(response => {
        //  this.post = response.body;
        //}, response => {
        //  console.log(response)
        //});
      },
    }
  };


</script>
