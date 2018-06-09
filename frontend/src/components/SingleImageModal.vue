<template>
  <div v-if="isActive" class="modal" v-bind:class="{ 'is-active': isActive }">
    <div class="modal-background" @click="$router.go(-1)"></div>
    <div class="modal-content">

      <div class="card large">
        <div class="card-image">
          <figure class="image">
            <img :src="imageData" alt="Image">
          </figure>
        </div>
        <div class="card-content">
          <div class="content">
            {{commentary}}
          </div>
        </div>
      </div>

    </div>
    <button class="modal-close is-large" @click="$router.go(-1)" aria-label="close"></button>
  </div>

</template>

<script>
  import links from '../links';
  import axios from 'axios';

  export default {
    props: ['imageId'],
    data: function () {
      return {
        commentary: '',
        isActive:false,
        imageData:'',
        commentaryLink:''
      }
    },
    watch: {
      imageId: function (newVal, oldVal) {
        if (newVal===undefined)
          this.isActive=false;
        if (newVal!==oldVal && newVal!==undefined){
        this.commentaryLink=links.url + '/description/' + newVal;
        this.imageLink=links.url + '/image/' + newVal;

        console.log(this.commentaryLink)
        axios.get(this.commentaryLink)
          .then(response => {
            this.commentary = decodeURIComponent(response.data);
            this.isActive=newVal !== undefined;
          });

        axios.get(this.imageLink)
          .then(response => {
            this.imageData=decodeURIComponent(response.data);
          });

          }
      }
    },
  }

</script>