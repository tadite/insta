<template>
<div class="field">
    <div class="field">
        <label class="label">Username</label>
        <div class="control">
          <input class="input" type="text" placeholder="Username" v-model="username">
        </div>
        </div>
        <div class="field">
          <label class="label">Password</label>
          <div class="control">
            <input class="input" placeholder="Password" v-model="password">
          </div>
        </div>

      <div class="field is-grouped">
        <div class="control ">
          <button class="button is-link" @click="login">Submit</button>
        </div>
        <div class="control">
            <router-link tag="button" class="button is-danger" to="/signup">Registration</router-link>
        </div>
      </div>
  </div>
</template>

<script>  
  import axios from 'axios';
  import links from '../links'

  export default {
    name: "LoginPage",
    data: function () {
      return {
        username: 'test-user',
        password: 'test-pass',
      }
    },
    methods: {
      login: function () {
        var postBody = {
          username: this.username,
          password: this.password
        };

        var signinUrl = links.url+'/auth/signin'

        console.log(postBody);
        axios.post(signinUrl, postBody)
          .then(response => {
            var token = response.data.tokenType + ' ' + response.data.accessToken;
            this.$store.state.username=this.username;
            this.$store.state.jwt=token;
            this.$store.state.authenticated=true;
            console.log(this.$store.state)
            this.$snotify.simple('Successful Login');
            this.$router.push('/profile/'+this.username);
          })
          .catch(error => {
            this.$snotify.simple(error.response.data.message);
          });
      }
    }
  };



</script>
