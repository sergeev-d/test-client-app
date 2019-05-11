<!--<template>-->
    <!--HTML  JS Result-->
    <!--EDIT ON-->
    <!--<div id="app">-->

        <!--<v-app>-->

            <!--<v-content>-->

                <!--<v-container>-->
                    <!--<v-stepper v-model="step" vertical>-->
                        <!--<v-stepper-header>-->
                            <!--<v-stepper-step step="1" :complete="step > 1">Your Information</v-stepper-step>-->
                            <!--<v-divider></v-divider>-->
                            <!--<v-stepper-step step="2" :complete="step > 2">Your Address</v-stepper-step>-->
                            <!--<v-divider></v-divider>-->
                            <!--<v-stepper-step step="3">Misc Info</v-stepper-step>-->
                        <!--</v-stepper-header>-->
                        <!--<v-stepper-items>-->
                            <!--<v-stepper-content step="1">-->

                                <!--<v-text-field label="Name" v-model="registration.name" required></v-text-field>-->
                                <!--<v-text-field label="Email" v-model="registration.email" required></v-text-field>-->

                                <!--<v-btn color="primary" @click.native="step = 2">Continue</v-btn>-->
                            <!--</v-stepper-content>-->
                            <!--<v-stepper-content step="2">-->

                                <!--<v-text-field label="Street" v-model="registration.street" required></v-text-field>-->
                                <!--<v-text-field label="City" v-model="registration.city" required></v-text-field>-->
                                <!--<v-text-field label="State" v-model="registration.state" required></v-text-field>-->

                                <!--<v-btn flat @click.native="step = 1">Previous</v-btn>-->
                                <!--<v-btn color="primary" @click.native="step = 3">Continue</v-btn>-->

                            <!--</v-stepper-content>-->
                            <!--<v-stepper-content step="3">-->

                                <!--<v-text-field label="Number of Tickets" type="number"-->
                                              <!--v-model="registration.numtickets" required></v-text-field>-->
                                <!--<v-select label="Shirt Size" v-model="registration.shirtsize"-->
                                          <!--:items="sizes" required></v-select>-->

                                <!--<v-btn flat @click.native="step = 2">Previous</v-btn>-->
                                <!--<v-btn color="primary" @click.prevent="submit">Save</v-btn>-->

                            <!--</v-stepper-content>-->
                        <!--</v-stepper-items>-->
                    <!--</v-stepper>-->

                <!--</v-container>-->

            <!--</v-content>-->

        <!--</v-app>-->
    <!--</div>-->
<!--</template>-->

<!--<script>-->
    <!--export default {-->
        <!--name: "StepProgressBar.vue"-->
    <!--}-->
<!--</script>-->

<!--<style scoped>-->


<!--</style>-->
