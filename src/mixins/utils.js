export const profileType = {
    methods:{
        isCustomer(profileType){
            return profileType.toLowerCase() === 'customer'
        },
        isExpert(profileType){
            return profileType.toLowerCase() === 'expert'
        }
    }
}
