package generated

final case class Data544(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data544 = copy(name = name.toUpperCase)
  def scale(k: Double): Data544 = copy(value = value * k)
  def addTag(t: String): Data544 = copy(tags = t :: tags)
  def put(k: String, v: String): Data544 = copy(meta = meta.updated(k, v))
  def merge(other: Data544): Data544 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data544 {
  given Ordering[Data544] = Ordering.by(_.id)
  def empty: Data544 = Data544(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data544 =
    Data544(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data544] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
