package generated

final case class Data716(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data716 = copy(name = name.toUpperCase)
  def scale(k: Double): Data716 = copy(value = value * k)
  def addTag(t: String): Data716 = copy(tags = t :: tags)
  def put(k: String, v: String): Data716 = copy(meta = meta.updated(k, v))
  def merge(other: Data716): Data716 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data716 {
  given Ordering[Data716] = Ordering.by(_.id)
  def empty: Data716 = Data716(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data716 =
    Data716(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data716] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
