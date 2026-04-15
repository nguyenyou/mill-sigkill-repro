package generated

final case class Data832(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data832 = copy(name = name.toUpperCase)
  def scale(k: Double): Data832 = copy(value = value * k)
  def addTag(t: String): Data832 = copy(tags = t :: tags)
  def put(k: String, v: String): Data832 = copy(meta = meta.updated(k, v))
  def merge(other: Data832): Data832 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data832 {
  given Ordering[Data832] = Ordering.by(_.id)
  def empty: Data832 = Data832(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data832 =
    Data832(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data832] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
