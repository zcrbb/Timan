<template>
  <div>
    <v-app id="inspire">
      <v-container class="fill-height" fluid>
        <v-row align-center justify-center>
          <v-col xs12 sm8 md4>
            <v-card class="mx-auto" max-width="600">
              <v-toolbar color="primary" dark flat>
                <v-toolbar-title v-if="login">Login</v-toolbar-title>
                <v-toolbar-title v-if="!login">Sign Up</v-toolbar-title>
              </v-toolbar>

              <v-card-text>
                <v-form>
                  <v-text-field
                    label="Login"
                    name="login"
                    prepend-icon="mdi-account"
                    v-model="loginForm.username"
                    :rules="nameRules"
                    type="text"
                  ></v-text-field>

                  <v-text-field
                    label="Email"
                    name="email"
                    prepend-icon="mdi-email"
                    v-model="loginForm.userEmail"
                    :rules="emailRules"
                    v-if="!login"
                    type="text"
                  ></v-text-field>

                  <v-text-field
                    id="password"
                    label="Password"
                    name="password"
                    prepend-icon="mdi-lock"
                    v-model="loginForm.password"
                    type="password"
                    :rules="passwordRules"
                  ></v-text-field>

                  <!-- 第二遍确认密码 注册时 -->
                  <v-text-field
                    id="password"
                    label="Confirm Password"
                    name="PasswordConfirm"
                    prepend-icon="mdi-lock"
                    type="password"
                    v-if="!login"
                    :rules="passwordRules"
                  ></v-text-field>
                </v-form>
                <p class="text-xs-center primary--text" @click="login=true;" v-if="!login">
                  <a>Already have an account? Sign in</a>
                </p>
                <p class="text-xs-center primary--text" @click="login=false" v-if="login">
                  <a>Don't have an account? Sign up</a>
                </p>
              </v-card-text>
              <v-card-actions>
                <v-spacer></v-spacer>

                <v-btn
                  color="primary"
                  v-if="login"
                  type="submit"
                  form="login-form"
                  :loading="loading"
                >Login</v-btn>
                <v-btn
                  color="primary"
                  v-if="!login"
                  type="submit"
                  form="login-form"
                  :loading="loading"
                >Sign Up</v-btn>
              </v-card-actions>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </v-app>
  </div>
</template>


<script>
export default {
  name: "Login",
  data() {
    return {
      loading: false,
      // 注册模式/登录模式
      login: true,
      nameRules: [
        v => {
          return v.length >= 5 || "Too short";
        }
      ],
      emailRules: [
        value => {
          const pattern = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
          return pattern.test(value) || "Invalid email.";
        }
      ],
      passwordRules: [
        value => {
          return value.length >= 5 || "Too short.";
        }
      ],
      loginForm: {
        username: "",
        password: ""
      },
      responseResult: []
    };
  },
  methods: {
    loginStart() {
      this.$axios
        .post("/login", {  
          username: this.loginForm.username,
          password: this.loginForm.password
        })
        .then(successResponse => {
          if (successResponse.data.code === 200) {
            this.$router.replace({ path: "/index" });
          }
        })
        .catch(failResponse => {});
    },
    checkPassword(invalid) {
      // correct: false
      if (true == invalid) {
        this.validPassword = false;
      } else {
        this.validPassword = true;
      }
    }
  }
};
</script>
