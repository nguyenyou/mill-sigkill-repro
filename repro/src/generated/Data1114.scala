package generated

final case class Data1114(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1114 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1114 = copy(value = value * k)
  def addTag(t: String): Data1114 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1114 = copy(meta = meta.updated(k, v))
  def merge(other: Data1114): Data1114 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1114 {
  given Ordering[Data1114] = Ordering.by(_.id)
  def empty: Data1114 = Data1114(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1114 =
    Data1114(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1114] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
