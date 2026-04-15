package generated

final case class Data301(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data301 = copy(name = name.toUpperCase)
  def scale(k: Double): Data301 = copy(value = value * k)
  def addTag(t: String): Data301 = copy(tags = t :: tags)
  def put(k: String, v: String): Data301 = copy(meta = meta.updated(k, v))
  def merge(other: Data301): Data301 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data301 {
  given Ordering[Data301] = Ordering.by(_.id)
  def empty: Data301 = Data301(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data301 =
    Data301(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data301] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
