import { Routes } from '@angular/router';
import { Login } from './pages/login/login';
import { BlockList } from './pages/blocks/block-list/block-list';
import { authGuard } from './core/guards/auth-guard';
import { BlockMap } from './pages/blocks/block-map/block-map';

export const routes: Routes = [

    {
        path: '',
        redirectTo: 'login',
        pathMatch: 'full'
    },

    {
        path: "login",
        component: Login
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
