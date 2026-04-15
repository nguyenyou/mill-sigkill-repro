package generated

final case class Data1111(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1111 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1111 = copy(value = value * k)
  def addTag(t: String): Data1111 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1111 = copy(meta = meta.updated(k, v))
  def merge(other: Data1111): Data1111 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1111 {
  given Ordering[Data1111] = Ordering.by(_.id)
  def empty: Data1111 = Data1111(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1111 =
    Data1111(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1111] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
