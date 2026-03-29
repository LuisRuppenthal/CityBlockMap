import { Routes } from '@angular/router';
import { Login } from './pages/login/login';
import { BlockList } from './pages/blocks/block-list/block-list';
import { BlockMap } from './pages/blocks/block-map/block-map';
import { Register } from './pages/register/register';
import { authGuard } from './core/guards/auth-guard';
import { adminGuard } from './core/guards/admin-guard';

export const routes: Routes = [

    {
        path: '',
        redirectTo: 'login',
        pathMatch: 'full'
    },

    /*{
        path: '**',
        redirectTo: 'login'
    },*/

    {
        path: 'login',
        component: Login
    },

    {
        path: 'register',
        component: Register,
        canActivate: [adminGuard]
    },

    {
        path: 'blocks',
        component: BlockList,
        canActivate: [authGuard]
    },

    {
        path: 'blocks/:id',
        component: BlockMap,
        canActivate: [authGuard]
    }
];