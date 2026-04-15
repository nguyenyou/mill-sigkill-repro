package generated

final case class Data626(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data626 = copy(name = name.toUpperCase)
  def scale(k: Double): Data626 = copy(value = value * k)
  def addTag(t: String): Data626 = copy(tags = t :: tags)
  def put(k: String, v: String): Data626 = copy(meta = meta.updated(k, v))
  def merge(other: Data626): Data626 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data626 {
  given Ordering[Data626] = Ordering.by(_.id)
  def empty: Data626 = Data626(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data626 =
    Data626(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data626] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
