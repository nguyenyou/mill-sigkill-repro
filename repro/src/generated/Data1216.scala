package generated

final case class Data1216(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1216 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1216 = copy(value = value * k)
  def addTag(t: String): Data1216 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1216 = copy(meta = meta.updated(k, v))
  def merge(other: Data1216): Data1216 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1216 {
  given Ordering[Data1216] = Ordering.by(_.id)
  def empty: Data1216 = Data1216(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1216 =
    Data1216(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1216] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
