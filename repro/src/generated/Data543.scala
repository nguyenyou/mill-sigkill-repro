package generated

final case class Data543(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data543 = copy(name = name.toUpperCase)
  def scale(k: Double): Data543 = copy(value = value * k)
  def addTag(t: String): Data543 = copy(tags = t :: tags)
  def put(k: String, v: String): Data543 = copy(meta = meta.updated(k, v))
  def merge(other: Data543): Data543 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data543 {
  given Ordering[Data543] = Ordering.by(_.id)
  def empty: Data543 = Data543(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data543 =
    Data543(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data543] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
