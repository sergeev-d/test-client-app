<template>
    <div class="wrapper">
        <div class="row">
            <div class="col-md-6 offset-3">
                <form action="" class="pt-3" @submit.prevent="onSubmit(email, password)">
                    <div class="form-group">
                        <label for="email">Логин</label>
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
                        <label for="password">Пароль</label>
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
                    <!--v-currentAssessment="confirmPassword"-->
                    <!--&gt;-->
                    <!--<div class="invalid-feedback" v-if="!$v.confirmPassword.sameAs">-->
                    <!--Password should be the same-->
                    <!--</div>-->
                    <!--</div>-->
                    <button
                            class="btn-blue"
                            type="submit"
                            :disabled="$v.$invalid"
                    >Вход</button>
                </form>
            </div>
        </div>
        <div style="height: 200px;"></div>
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
                this.$store.dispatch(LOGIN, { email, password } )
                    .then(() => this.$router.push({ name: 'home' }))
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
                            const val = newEmail!== 'test@mail.ru';
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
