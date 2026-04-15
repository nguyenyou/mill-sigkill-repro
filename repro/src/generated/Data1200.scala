package generated

final case class Data1200(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1200 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1200 = copy(value = value * k)
  def addTag(t: String): Data1200 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1200 = copy(meta = meta.updated(k, v))
  def merge(other: Data1200): Data1200 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1200 {
  given Ordering[Data1200] = Ordering.by(_.id)
  def empty: Data1200 = Data1200(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1200 =
    Data1200(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1200] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
