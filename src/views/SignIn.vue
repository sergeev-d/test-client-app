<template>
    <div class="container">
        <form action="" class="pt-3" @submit.prevent="onSubmit(email, password)">
            <div class="form-group">
                <label for="email">Email</label>
                <input
                        type="email"
                        id="email"
                        class="form-control"
                        :class="{'is-invalid': $v.email.$error}"
                        @blur="$v.email.$touch()"
                        v-model="email"
                >
                <div class="invalid-feedback" v-if="!$v.email.required">Email field is required</div>
                <div class="invalid-feedback" v-if="!$v.email.email">This field should be an email</div>
                <div class="invalid-feedback" v-if="!$v.email.uniqueEmail">This email already registered</div>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input
                        type="password"
                        id="password"
                        class="form-control form-control-sm"
                        :class="{'is-invalid': $v.password.$error}"
                        @blur="$v.password.$touch()"
                        v-model="password"
                >
                <div class="invalid-feedback" v-if="!$v.password.required">Password field is required</div>
                <div class="invalid-feedback" v-if="!$v.password.minLength">
                    Password field should be more than {{ $v.password.$params.minLength.min }}, now is {{ password.length }}
                </div>
            </div>
            <!--<div class="form-group">-->
                <!--<label for="confirmPassword">Confirm password</label>-->
                <!--<input-->
                        <!--type="password"-->
                        <!--id="confirmPassword"-->
                        <!--class="form-control form-control-sm"-->
                        <!--:class="{'is-invalid': $v.confirmPassword.$error}"-->
                        <!--@blur="$v.confirmPassword.$touch()"-->
                        <!--v-model="confirmPassword"-->
                <!--&gt;-->
                <!--<div class="invalid-feedback" v-if="!$v.confirmPassword.sameAs">-->
                    <!--Password should be the same-->
                <!--</div>-->
            <!--</div>-->
            <button
                    class="btn btn-success"
                    type="submit"
                    :disabled="$v.$invalid"
            >Submit</button>
        </form>
    </div>
</template>
<script>
    // import { required, email, minLength, sameAs } from 'vuelidate/lib/validators'
    import { required, email, minLength } from 'vuelidate/lib/validators'
    import { LOGIN } from "../store/actions.type"

    export default {
        name : "SignIn",
        data () {
            return {
                email: '',
                password: '',
                confirmPassword: ''
            }
        },
        methods: {
            onSubmit (email, password) {
                this.$store.dispatch(LOGIN, { email, password} )
                    .then(() => this.$router.push({ name: "home" }))
            }
        },
        validations: {
            email: {
                required,
                email,
                uniqueEmail: function (newEmail) {
                    if (newEmail === '') return true
                    return new Promise((resolve) => {
                        setTimeout(() => {
                            const val = newEmail!== 'test@mail.ru'
                            resolve(val)
                        }, 1000)
                    })
                }
            },
            password: {
                required,
                minLength: minLength(8)
            }
            // ,
            // confirmPassword: {
            //     sameAs: sameAs((vue) => {
            //         return vue.password
            //     })
            // }
        }
    }
</script>
<style>
</style>
