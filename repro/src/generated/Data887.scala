package generated

final case class Data887(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data887 = copy(name = name.toUpperCase)
  def scale(k: Double): Data887 = copy(value = value * k)
  def addTag(t: String): Data887 = copy(tags = t :: tags)
  def put(k: String, v: String): Data887 = copy(meta = meta.updated(k, v))
  def merge(other: Data887): Data887 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data887 {
  given Ordering[Data887] = Ordering.by(_.id)
  def empty: Data887 = Data887(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data887 =
    Data887(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data887] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
