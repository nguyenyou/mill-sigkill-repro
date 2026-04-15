package generated

final case class Data20(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data20 = copy(name = name.toUpperCase)
  def scale(k: Double): Data20 = copy(value = value * k)
  def addTag(t: String): Data20 = copy(tags = t :: tags)
  def put(k: String, v: String): Data20 = copy(meta = meta.updated(k, v))
  def merge(other: Data20): Data20 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data20 {
  given Ordering[Data20] = Ordering.by(_.id)
  def empty: Data20 = Data20(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data20 =
    Data20(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data20] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
