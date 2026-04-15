package generated

final case class Data133(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data133 = copy(name = name.toUpperCase)
  def scale(k: Double): Data133 = copy(value = value * k)
  def addTag(t: String): Data133 = copy(tags = t :: tags)
  def put(k: String, v: String): Data133 = copy(meta = meta.updated(k, v))
  def merge(other: Data133): Data133 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data133 {
  given Ordering[Data133] = Ordering.by(_.id)
  def empty: Data133 = Data133(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data133 =
    Data133(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data133] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
