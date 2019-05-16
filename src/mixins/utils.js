export const profileType = {
    methods:{
        isCustomer(profileType){
            return profileType === 0
        },
        isExpert(profileType){
            return profileType === 1
        }
    }
}
