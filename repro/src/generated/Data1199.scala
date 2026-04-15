package generated

final case class Data1199(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1199 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1199 = copy(value = value * k)
  def addTag(t: String): Data1199 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1199 = copy(meta = meta.updated(k, v))
  def merge(other: Data1199): Data1199 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1199 {
  given Ordering[Data1199] = Ordering.by(_.id)
  def empty: Data1199 = Data1199(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1199 =
    Data1199(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1199] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
