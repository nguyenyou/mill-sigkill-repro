package generated

final case class Data1407(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1407 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1407 = copy(value = value * k)
  def addTag(t: String): Data1407 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1407 = copy(meta = meta.updated(k, v))
  def merge(other: Data1407): Data1407 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1407 {
  given Ordering[Data1407] = Ordering.by(_.id)
  def empty: Data1407 = Data1407(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1407 =
    Data1407(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1407] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
