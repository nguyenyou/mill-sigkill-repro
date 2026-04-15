package generated

final case class Data510(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data510 = copy(name = name.toUpperCase)
  def scale(k: Double): Data510 = copy(value = value * k)
  def addTag(t: String): Data510 = copy(tags = t :: tags)
  def put(k: String, v: String): Data510 = copy(meta = meta.updated(k, v))
  def merge(other: Data510): Data510 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data510 {
  given Ordering[Data510] = Ordering.by(_.id)
  def empty: Data510 = Data510(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data510 =
    Data510(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data510] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
