<template>
<div>
<ProfileDataPanel :profileData="profileData" :editing="this.$route.params.edit"/>
<ProfileImageTile :imageIds="imageIds" :editing="this.$route.params.edit"/>
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
        imageIds: ['1','2','3','4','5','6','7'],
        profileData:{
          username: 'tadite',
          fullname: 'Andrey Nazarov',
          info: 'My super profile'
        }
      }
    },
    watch: {
      '$route' (to, from) {
        console.log(this.$route.params.edit)
        console.log(this.$route.params.profileId)
        console.log(this.$route.params.imageId)
        this.fetchProfileData(this.$route.params.profileId);
      }
    },
    created:function(){
      this.fetchProfileData('');
    },
    methods: {
      fetchProfileData: function(profileName){
        
        console.log('fetch profile '+profileName);
        //this.$http.get('/post/' + postId).then(response => {
        //  this.post = response.body;
        //}, response => {
        //  console.log(response)
        //});
      },
    },
    components: {
      ProfileImageTile,
      ProfileDataPanel,
      SingleImageModal
    }
  };


</script>
