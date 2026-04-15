package generated

final case class Data1371(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1371 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1371 = copy(value = value * k)
  def addTag(t: String): Data1371 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1371 = copy(meta = meta.updated(k, v))
  def merge(other: Data1371): Data1371 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1371 {
  given Ordering[Data1371] = Ordering.by(_.id)
  def empty: Data1371 = Data1371(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1371 =
    Data1371(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1371] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
