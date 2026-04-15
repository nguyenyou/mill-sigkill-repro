package generated

final case class Data1445(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1445 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1445 = copy(value = value * k)
  def addTag(t: String): Data1445 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1445 = copy(meta = meta.updated(k, v))
  def merge(other: Data1445): Data1445 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1445 {
  given Ordering[Data1445] = Ordering.by(_.id)
  def empty: Data1445 = Data1445(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1445 =
    Data1445(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1445] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
