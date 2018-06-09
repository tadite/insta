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

  import axios from 'axios';
  import links from '../links';

  export default {
    name: "Profile",
    data: function() { 
      return {
        isLoaded:false,
        imageIds: [],
        profileData:{
          username: '',
          fullname: '',
          info: ''
        }
      };
    },
    watch: {
      '$route' (to, from) {
       // var newProfileUsername = this.$route.params.profileId
        //if (newProfileUsername!==undefined && this.profileData.username!==newProfileUsername)
          this.fetchProfileData(this.$route.params.profileId);
      }
    },
    created:function(){
      //var newProfileUsername = this.$route.params.profileId
     // if (newProfileUsername!==undefined && this.profileData.username!==newProfileUsername)
          this.fetchProfileData(this.$route.params.profileId);
    },
    methods: {
      fetchProfileData: function(profileName){
        
        console.log('fetch profile '+profileName);
        var currentProfileLink = links.url+'/profile/'+profileName;
        
        axios.get(currentProfileLink)
          .then(response => {  
            console.log(response.data.profileData.username)
            this.profileData.username=response.data.profileData.username;
            this.profileData.fullname=response.data.profileData.fullname;
            this.profileData.info=response.data.profileData.info || " ";
            this.imageIds=response.data.imageIds;
          })
          .catch(error => {
            console.log(error.response)
          });

          console.log(this.profileData)
      },
    },
    components: {
      ProfileImageTile,
      ProfileDataPanel,
      SingleImageModal
    }
  };


</script>
