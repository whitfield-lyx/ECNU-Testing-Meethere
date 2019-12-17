import Vue from 'vue'
import Router from 'vue-router'
import pageBooking from '../components/pages/pageBooking'
import pageLogin from '../components/pages/pageLogin'
import pageMain from '../components/pages/pageMain'
import pageInformation from '../components/pages/pageInformation'
import pageMessage from '../components/pages/pageMessage'
import pageNews from '../components/pages/pageNews'
import pageOrder from '../components/pages/pageOrder'
import pagePublishMessage from '../components/pages/pagePublishMessage'
import pagePublishNews from '../components/pages/pagePublishNews'
import pageSignIn from '../components/pages/pageSignIn'
import pageVerifyMessage from '../components/pages/pageVerifyMessage'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Login',
      component: pageLogin,
      meta: {
        keepalive: false
      }
    },
    {
      path: '/Main',
      name: 'Main',
      component: pageMain,
      meta: {
        keepalive: true
      },
      children: [
        {
          path: 'Booking',
          name: 'Booking',
          component: pageBooking,
          meta: {
            keepalive: true
          }
        },
        {
          path: 'Information',
          name: 'Information',
          component: pageInformation,
          meta: {
            keepalive: true
          }
        },
        {
          path: 'Message',
          name: 'Message',
          component: pageMessage,
          meta: {
            keepalive: true
          }
        },
        {
          path: 'News',
          name: 'News',
          component: pageNews,
          meta: {
            keepalive: true
          }
        },
        {
          path: 'Order',
          name: 'Order',
          component: pageOrder,
          meta: {
            keepalive: true
          }
        },
        {
          path: 'Publish',
          name: 'Publish',
          component: pagePublishMessage,
          meta: {
            keepalive: true
          }
        },
        {
          path: 'PublishNews',
          name: 'PublishNews',
          component: pagePublishNews,
          meta: {
            keepalive: true
          }
        },
        {
          path: 'SignIn',
          name: 'SignIn',
          component: pageSignIn,
          meta: {
            keepalive: false
          }
        },
        {
          path: 'Verify',
          name: 'Verify',
          component: pageVerifyMessage,
          meta: {
            keepalive: true
          }
        }
      ]
    }
  ]
})
