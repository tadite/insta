<template>
  <div v-if="isActive" class="modal" v-bind:class="{ 'is-active': isActive }">
    <div class="modal-background" @click="$router.go(-1)"></div>
    <div class="modal-content">

      <div class="card large">
        <div class="card-image">
          <figure class="image">
            <img :src="imageLink" alt="Image">
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
  props:['imageId'],
  data: function(){
    return{
      commentary:'',
      isActive:'',
      imageLink:''
    }
  },
  created() {
    if (this.imageId==undefined)
      return;

    var commentaryUrl = links.url+'/description/'+this.imageId;

      axios.get(commentaryUrl)
      .then(response => {  
            console.log(response.data);
            this.commentary=response.data;
            this.isActive=this.imageId!=undefined;
            this.imageLink=links.url+'/image/'+this.imageId;
          })
          .catch(error => {
            console.log(error.response)
          });
    
  }
}
</script>