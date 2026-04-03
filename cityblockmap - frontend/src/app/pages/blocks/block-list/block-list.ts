import { ChangeDetectorRef, Component, inject, OnInit } from '@angular/core';
import { BlockService } from '../../../core/services/blockService';
import { Router } from '@angular/router';
import { Block } from '../../../core/models/block.model';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-block-list',
  imports: [CommonModule],
  templateUrl: './block-list.html',
  styleUrl: './block-list.css',
})
export class BlockList implements OnInit {

  private blockService = inject(BlockService);
  private router = inject(Router);
  private cdr = inject(ChangeDetectorRef)

  blocks: Block[] = [];
  loading = false;
  errorMessage = '';

  ngOnInit(): void {
    this.loadBlocks();
  }

  loadBlocks(): void {
    this.loading = true;

    this.blockService.getAll().subscribe({
      next: (response) => {
        this.blocks = response;
        this.loading = false;
        this.cdr.detectChanges();
      },
      error: () => {
        this.errorMessage = 'Erro ao carregar as quadras.';
        this.loading = false;
        this.cdr.detectChanges();
      }
    });
  }

  openBlock(id: number): void {
    this.router.navigate(['/blocks', id])
  }
}
