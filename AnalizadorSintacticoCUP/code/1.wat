(module
(type $_sig_i32i32i32 (func (param i32 i32 i32) ))
(type $_sig_i32ri32 (func (param i32) (result i32)))
(type $_sig_i32 (func (param i32)))
(type $_sig_ri32 (func (result i32)))
(type $_sig_void (func ))
(import "runtime" "exceptionHandler" (func $exception (type $_sig_i32)))
(import "runtime" "print" (func $show (type $_sig_i32)))
(import "runtime" "read" (func $read (type $_sig_ri32)))
(memory 2000)
(global $SP (mut i32) (i32.const 0)) ;; start of stack
(global $MP (mut i32) (i32.const 0)) ;; mark pointer
(global $NP (mut i32) (i32.const 131071996)) ;; heap 2000*64*1024-4
(start $preMain)
(func $preMain 
 (local $temp i32)
 (local $localsStart i32)
 i32.const 16
 call $reserveStack
 local.set $temp
 global.get $MP
 local.get $temp
 i32.store
 global.get $MP
 i32.const 4
 i32.add
 local.set $localsStart
 ;;generating code for declaration dec:x(type:INT)=(INT:0)
 i32.const 0
 ;;generating code for EConst
 i32.const 0
 i32.store
 ;;end generating code for declaration
 ;;generating code for declaration dec:y(type:INT)=(INT:4)
 i32.const 4
 ;;generating code for EConst
 i32.const 4
 i32.store
 ;;end generating code for declaration
 ;; generating code of const z
 i32.const 8
 ;;generating code for EConst
 i32.const 0
 i32.store
 call $main
 drop
 call $freeStack
)
 ;; generating code of function main
(func $main
 (result i32)
 (local $temp i32)
 (local $localsStart i32)
 i32.const 44
 call $reserveStack
 local.set $temp
 global.get $MP
 local.get $temp
 i32.store
 global.get $MP
 i32.const 4
 i32.add
 local.set $localsStart
 ;;generating code for declaration dec:x(type:INT)=(INT:1)
 i32.const 0
 local.get $localsStart
 i32.add
 ;;generating code for EConst
 i32.const 1
 i32.store
 ;;end generating code for declaration
 ;;generating code for assignation assign:AVar(x)=SUM(AVar(x),(INT:1))
 i32.const 0
 local.get $localsStart
 i32.add
 ;;generating code for exp ebinSUM(AVar(x),(INT:1))
 ;;generating code for access
 i32.const 0
 local.get $localsStart
 i32.add
 i32.load
 ;;generating code for EConst
 i32.const 1
 i32.add
 i32.store
 ;;generating code for assignation assign:AVar(x)=SUB(AVar(x),(INT:1))
 i32.const 0
 local.get $localsStart
 i32.add
 ;;generating code for exp ebinSUB(AVar(x),(INT:1))
 ;;generating code for access
 i32.const 0
 local.get $localsStart
 i32.add
 i32.load
 ;;generating code for EConst
 i32.const 1
 i32.sub
 i32.store
 ;;generating code for declaration dec:y(type:INT)=AVar(x)
 i32.const 0
 local.get $localsStart
 i32.add
 i32.const 4
 local.get $localsStart
 i32.add
 i32.const 1
 call $copyn
 ;;end generating code for declaration
 ;;generating code for assignation assign:AVar(y)=(INT:0)
 i32.const 4
 local.get $localsStart
 i32.add
 ;;generating code for EConst
 i32.const 0
 i32.store
 ;;generating code for assignation assign:AVar(y)=(INT:1)
 i32.const 4
 local.get $localsStart
 i32.add
 ;;generating code for EConst
 i32.const 1
 i32.store
 ;; generating code for IShow
 ;;generating code for access
 i32.const 0
 local.get $localsStart
 i32.add
 i32.load
 call $show
 ;;generating code for declaration dec:array(type:List<INT>[(INT:1)])
 ;;end generating code for declaration
 ;;generating code for assignation assign:AVar(array)=[(INT:1)]
 i32.const 8
 local.get $localsStart
 i32.add
 i32.const 0
 i32.add
 ;;generating code for EConst
 i32.const 1
 i32.store
 ;;generating code for assignation assign:AArray (AVar(array)[(INT:0)])=(INT:2)
 ;;generating code for index of array(INT:0)
 ;;generating code for EConst
 i32.const 0
 i32.const 4
 i32.mul
 ;;generating code for access arrayAVar(array)
 i32.const 8
 local.get $localsStart
 i32.add
 i32.add
 ;;end of generating code for access to array
 ;;generating code for EConst
 i32.const 2
 i32.store
 ;;generating code for declaration dec:array1(type:List<INT>[(INT:1)])
 ;;end generating code for declaration
 ;;generating code for assignation assign:AVar(array1)=[(INT:1)]
 i32.const 12
 local.get $localsStart
 i32.add
 i32.const 0
 i32.add
 ;;generating code for EConst
 i32.const 1
 i32.store
 ;;generating code for assignation assign:AVar(array)=AVar(array1)
 i32.const 12
 local.get $localsStart
 i32.add
 i32.const 8
 local.get $localsStart
 i32.add
 i32.const 1
 call $copyn
 ;;generating code for declaration dec:array2(type:List<List<INT>[(INT:1)]*>[(INT:2)])
 ;;end generating code for declaration
 ;;generating code for declaration dec:puntero(type:List<INT>[(INT:1)]*)=new List<INT>[(INT:1)]
 i32.const 24
 local.get $localsStart
 i32.add
 i32.const 4
 call $reserveHeap 
 global.get $NP
 i32.store
 ;;end generating code for declaration
 ;;generating code for assignation assign:APointer(*AVar(puntero))=[(INT:1)]
 ;;generating code for APointer AVar(puntero)
 ;;generating code for declaration dec:puntero(type:List<INT>[(INT:1)]*)=new List<INT>[(INT:1)]
 i32.const 24
 local.get $localsStart
 i32.add
 i32.const 4
 call $reserveHeap 
 global.get $NP
 i32.store
 ;;end generating code for declaration
 i32.const 0
 i32.add
 ;;generating code for EConst
 i32.const 1
 i32.store
 ;;generating code for assignation assign:AArray (AVar(array2)[(INT:0)])=AVar(puntero)
 i32.const 24
 local.get $localsStart
 i32.add
 ;;generating code for index of array(INT:0)
 ;;generating code for EConst
 i32.const 0
 i32.const 4
 i32.mul
 ;;generating code for access arrayAVar(array2)
 i32.const 16
 local.get $localsStart
 i32.add
 i32.add
 ;;end of generating code for access to array
 i32.const 1
 call $copyn
 ;;generating code for declaration dec:aux(type:List<INT>[(INT:1)])=APointer(*AArray (AVar(array2)[(INT:0)]))
 ;;generating code for APointer AArray (AVar(array2)[(INT:0)])
 ;;generating code for declaration dec:array2(type:List<List<INT>[(INT:1)]*>[(INT:2)])
 ;;end generating code for declaration
 i32.const 28
 local.get $localsStart
 i32.add
 i32.const 1
 call $copyn
 ;;end generating code for declaration
 ;;generating code for declaration dec:a(type:INT)=AArray (APointer(*AArray (AVar(array2)[(INT:0)]))[(INT:0)])
 ;;generating code for index of array(INT:0)
 ;;generating code for EConst
 i32.const 0
 i32.const 4
 i32.mul
 ;;generating code for access arrayAPointer(*AArray (AVar(array2)[(INT:0)]))
 ;;generating code for APointer AArray (AVar(array2)[(INT:0)])
 ;;generating code for declaration dec:array2(type:List<List<INT>[(INT:1)]*>[(INT:2)])
 ;;end generating code for declaration
 i32.add
 ;;end of generating code for access to array
 i32.const 32
 local.get $localsStart
 i32.add
 i32.const 1
 call $copyn
 ;;end generating code for declaration
 ;; generating code for IReturn
 ;;generating code for EConst
 i32.const 0
 call $freeStack
 return
 call $freeStack
)
(func $reserveStack (param $size i32)
   (result i32)
   global.get $MP
   global.get $SP
   global.set $MP
   global.get $SP
   local.get $size
   i32.add
   global.set $SP
   global.get $SP
   global.get $NP
   i32.gt_u
   if
   i32.const 3
   call $exception
   end
)

(func $freeStack (type $_sig_void)
   global.get $MP
   i32.load
   i32.load offset=4
   global.set $SP
   global.get $MP
   i32.load
   global.set $MP   
)

(func $reserveHeap (type $_sig_i32)
   (param $size i32)


   global.get $NP
   local.get $size
   i32.sub
   global.set $NP
  


)

(func $copyn (type $_sig_i32i32i32) ;; copy $n i32 slots from $src to $dest
   (param $src i32)
   (param $dest i32)
   (param $n i32)
   block
     loop
       local.get $n
       i32.eqz
       br_if 1
       local.get $n
       i32.const 1
       i32.sub
       local.set $n
       local.get $dest
       local.get $src
       i32.load
       i32.store
       local.get $dest
       i32.const 4
       i32.add
       local.set $dest
       local.get $src
       i32.const 4
       i32.add
       local.set $src
       br 0
     end
   end
)
)
