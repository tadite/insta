<template>
  <div class="field">
    <div class="notification has-background-light">
      <button class="delete" @click="$router.go(-1)"></button>

<div class="field">
      <div class="file">
        <label class="file-label">
          <input class="file-input" type="file" name="resume" @change="onFileChange">
          <span class="file-cta">
            <span class="file-icon">
              <i class="fas fa-upload"></i>
            </span>
            <span class="file-label">
              Choose a photo...
            </span>
          </span>
        </label>
      </div>
     </div>

    <div class="field" v-if="image">

      <div class="field">
        <img class="upload-img" :src="image" />
        <button class="button is-danger" @click="removeImage">Remove image</button>
      </div>

      <div class="field">
        <label class="label">Image commentary</label>
        <div class="control">
          <textarea class="input" type="text" placeholder="Image commentary" v-model="commentary"/>
        </div>
      </div>

      <div class="control">
        <button class="button is-success" @click="uploadImage">Save</button>
      </div>

    </div>

  </div>
  </div>


</template>

<script>  
  import links from '../links';
  import axios from 'axios';

  export default {
    name: "ImageUploadPanel",
    data: function () {
      return {
        image: '',
        commentary: ''
      }
    },
    created: function () {},
    methods: {
      uploadImage(){
        var uploadImageUrl = links.url+'/image';

        axios.post(uploadImageUrl, this.image, {
            headers: { Authorization: this.$store.state.jwt }
          })
          .then(response => {
            var id = response.data;
            this.updateCommentary(id);
          })
          .catch(error => {
            this.$snotify.simple(error.response.data.message);
          });
      },
      updateCommentary(imgId){
        var uploadImageUrl = links.url+'/image/'+imgId;
        console.log(this.commentary);
        axios.post(uploadImageUrl, this.commentary, {
            headers: { Authorization: this.$store.state.jwt }
          }
        )
          .then(response => {
            console.log('comment');
            console.log(response);
            this.$snotify.simple('Image uploaded');            
          })
          .catch(error => {
            this.$snotify.simple(error.response.data.message);
          });
      },
      onFileChange(e) {
        var files = e.target.files || e.dataTransfer.files;
        if (!files.length)
          return;
        this.createImage(files[0]);
      },
      createImage(file) {
        var image = new Image();
        var reader = new FileReader();
        var vm = this;

        reader.onload = (e) => {
          vm.image = e.target.result;
        };

        var test = reader.readAsDataURL(file);
        console.log(test);
      },
      removeImage: function (e) {
        this.image = '';
      }
    },
    components: {}
  };



</script>
