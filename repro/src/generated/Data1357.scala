package generated

final case class Data1357(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1357 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1357 = copy(value = value * k)
  def addTag(t: String): Data1357 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1357 = copy(meta = meta.updated(k, v))
  def merge(other: Data1357): Data1357 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1357 {
  given Ordering[Data1357] = Ordering.by(_.id)
  def empty: Data1357 = Data1357(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1357 =
    Data1357(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1357] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
