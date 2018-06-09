<template>
  <div class="field">
    <div class="notification has-background-light">
      <button class="delete" @click="$router.go(-1)"></button>

      <div class="field">
        <label class="label">Full Name</label>
        <div class="control">
          <input class="input" type="text" placeholder="Text input">
        </div>
</div>
        <div class="field">
          <label class="label">Message</label>
          <div class="control">
            <textarea class="textarea" placeholder="Textarea"></textarea>
          </div>
        </div>

      <div class="field is-grouped">
        <div class="control">
          <button class="button is-link">Submit</button>
        </div>
        <div class="control">
          <button class="button is-text">Cancel</button>
        </div>
      </div>

    </div>
  </div>
</template>


<script>  

  export default {
    name: "ProfileEdit",
    created:function(){
    },
    components: {
    }
  };


</script>
