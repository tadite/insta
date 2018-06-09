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
        <div class="field">
          <label class="label">Full name</label>
          <div class="control">
            <input class="input" placeholder="Full name" v-model="fullName">
          </div>
        </div>

      <div class="field is-grouped">
        <div class="control ">
          <button class="button is-link" @click="login">Submit</button>
        </div>
        <div class="control">
            <router-link tag="button" class="button is-danger" to="/signin">Back</router-link>
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
        fullName: 'Test Petrovich'
      }
    },
    methods: {
      login: function () {
        console.log(links.url);

        var postBody = {
          username: this.username,
          password: this.password,
          fullName: this.fullName,
        };

        var signinUrl = links.url + '/auth/signup'

        console.log(postBody);
        axios.post(signinUrl, postBody)
          .then(response => {
            console.log(response)
            this.$snotify.simple('Successful Registration');
            this.$router.push('/signin');
          })
          .catch(error => {
            this.$snotify.simple(error.response.data.message);
          });
      }
    }
  };
</script>
