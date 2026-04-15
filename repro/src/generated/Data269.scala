package generated

final case class Data269(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data269 = copy(name = name.toUpperCase)
  def scale(k: Double): Data269 = copy(value = value * k)
  def addTag(t: String): Data269 = copy(tags = t :: tags)
  def put(k: String, v: String): Data269 = copy(meta = meta.updated(k, v))
  def merge(other: Data269): Data269 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data269 {
  given Ordering[Data269] = Ordering.by(_.id)
  def empty: Data269 = Data269(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data269 =
    Data269(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data269] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
