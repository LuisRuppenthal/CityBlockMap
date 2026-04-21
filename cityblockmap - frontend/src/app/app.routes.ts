import { Routes } from '@angular/router';
import { Login } from './pages/login/login';
import { BlockList } from './pages/blocks/block-list/block-list';
import { BlockMap } from './pages/blocks/block-map/block-map';
import { Register } from './pages/register/register';
import { authGuard } from './core/guards/auth-guard';
import { adminGuard } from './core/guards/admin-guard';
import { NotFound } from './pages/not-found/not-found';
import { BlockRegister } from './pages/blocks/block-register/block-register';
import { BlockEdit } from './pages/blocks/block-edit/block-edit';
import { Path } from 'leaflet';
import { NeighborhoodList } from './pages/neighborhoods/neighborhood-list/neighborhood-list';

export const routes: Routes = [

    {
        path: '',
        redirectTo: 'login',
        pathMatch: 'full'
    },

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
        path: 'neighborhoods',
        component: NeighborhoodList,
        canActivate: [authGuard]
    },

    {
        path: 'blocks',
        component: BlockList,
        canActivate: [authGuard]
    },

    {
        path: 'block-register',
        component: BlockRegister,
        canActivate: [adminGuard]
    },

    {
        path: 'block-edit/:id',
        component: BlockEdit,
        canActivate: [adminGuard]
    },

    {
        path: 'blocks/:id',
        component: BlockMap,
        canActivate: [authGuard]
    },

    {
        path: '**',
        component: NotFound
    }
];