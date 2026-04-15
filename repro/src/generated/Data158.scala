package generated

final case class Data158(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data158 = copy(name = name.toUpperCase)
  def scale(k: Double): Data158 = copy(value = value * k)
  def addTag(t: String): Data158 = copy(tags = t :: tags)
  def put(k: String, v: String): Data158 = copy(meta = meta.updated(k, v))
  def merge(other: Data158): Data158 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data158 {
  given Ordering[Data158] = Ordering.by(_.id)
  def empty: Data158 = Data158(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data158 =
    Data158(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data158] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
